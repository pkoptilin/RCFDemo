package com.selectica.rcfdev.eclm.definitions.CProcBO.actions;

import com.selectica.rcfdev.eclm.definitions.ReminderStatus;
import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.System.stubs.Reminder;
import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFSchedulerAPI;
import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by vshilkin on 25/12/2014.
 */
public class CreateNotificationAlertAction extends AbstractBOWriteScript<Boolean> {
    /*
                    <![CDATA[
                               var endDate = thisComponent.getBundleProxy().getValueFromInfo("endDate");
                               if (endDate == null) {
                                   result = false;
                               }
                               if ("yes".equalsIgnoreCase(thisComponent.get("autoRenewal").toString())) {
                                   var objDate = thisComponent.get("/endDate");
                                   var jendDate = new Packages.org.joda.time.DateTime(objDate.getTime().getTime()).withTimeAtStartOfDay();//end date with start of the day time
                                   var noticePeriod = 0;
                                   noticePeriod = thisComponent.get("renNoticePer");

                                   var reminder = thisComponent.addNode("ReqReminder/");
                                   var recipient = reminder.addNode("/ReqReminderRecipientAccountUser/");
                                   reminder.setValue("/status", "active", false);
                                   reminder.setValue("/eventType", endDate.getDefinition().getAbsoluteJXPath(), false);
                                   reminder.setValue("/resolvedEventDate", endDate.getValue(), false);

                                   var dateTime = jendDate.minusDays(noticePeriod).withTimeAtStartOfDay();
                                   var clnd = Packages.java.util.Calendar.getInstance();
                                   clnd.setTime(new Packages.java.util.Date(dateTime.getMillis()));

                                   reminder.setDateValue("/notificationDate", clnd, false);
                                   reminder.setValue("/notificationDelta", ""+ noticePeriod, false);
                                   reminder.setValue("/notificationFreq", "once", false);
                                   reminder.setValue("/subject", "Renewal notification letter", false);
                                   var sb = "Your contract "+thisComponent.get("name").toString()+" will be automatically renewed at "+endDate.getDisplayValue();
                                   reminder.setValue("/comments", sb.toString(), false);
                                   recipient.setValue("/accountUserRecipient", thisComponent.getBundleProxy().getOwner().getID(), false);
                                   reminder.save();
                                  recipient.save();
                           	   scheduler.scheduleReminder(node, reminder);
                               }
                               result = true;

				]]>

     */
    @Override
    public Boolean process() throws Exception {
        boolean result = false;

        CPDetails info = getHelper().getInfoComponentStub();
        Date endDate = info.getEndDate();
        if (endDate != null) {
            if ("yes".equals(info.getAutoRenewal())) {

                DateTime jEndDate = new DateTime(endDate.getTime()).withTimeAtStartOfDay();
                Integer noticePeriod = info.getRenNoticePer();
                if (noticePeriod == null) {
                    noticePeriod = 0;
                }

                Reminder reminder = getHelper().addNewComponent("ReqReminder");
                reminder.setStatus(ReminderStatus.ACTIVE.getStatus());
                reminder.setEventType(getHelper().getParameterDefinitionHelper(info, "endDate").getAbsoluteJXPath());
                reminder.setResolvedEventDate(endDate);

                DateTime dateTime = jEndDate.minusDays(noticePeriod).withTimeAtStartOfDay();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(dateTime.getMillis());
                reminder.setNotificationDate(calendar.getTime());
                reminder.setNotificationDelta(noticePeriod);
                reminder.setNotificationFreq("once");
                reminder.setSubject("Renewal notification letter");
                reminder.setComments("Your contract " + info.getContractName() + " will be automatically renewed at " + endDate.getDate());

                reminder.setRecipientAccountUser(getHelper().getCurrentBundleWrapper().getOwnerEmail());
                getHelper().saveComponent(reminder);

//                ReminderRecipientAccountUser recipient = getHelper().addNewSubComponent("ReqReminderRecipientAccountUser", reminder);
//                recipient.setAccountUserRecipient(getHelper().getCurrentBundleWrapper().getOwnerID());
//                getHelper().saveComponent(recipient);

                RCFSchedulerAPI.scheduleReminder(reminder);
                result = true;
            }
        }
        return result;
    }
}
