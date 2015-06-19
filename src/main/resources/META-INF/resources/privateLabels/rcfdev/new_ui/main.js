(function () {
    'use strict';

    window.eCLMExtension = {
        layout: {}
    };

    var extension = window.eCLMExtension;

    extension.layout = {
        footer: function () {
            return '' +
                '<div class="copyright"><div class="logo"></div>' +
                'Copyright &copy; 2014, Selectica, Inc. All rights reserved.' +
                '</div>' +
                '<a href="http://www.selectica.com/" class="powered"></a>' +
                '<ul class="links">' +
                '<li>' +
                '<a href="http://www.selectica.com/Terms.aspx" target="_blank">Legal Statement</a>' +
                '</li>' +
                '<li>' +
                '<a href="http://www.selectica.com/Privacy.aspx" target="_blank">Privacy</a>' +
                '</li>' +
                '<li>' +
                '<a href="http://www.selectica.com/ContactUs/tabid/205/Default.aspx" target="_blank">Feedback</a>' +
                '</li>' +
                '<li>' +
                '<a href="http://www.selectica.com/ContactUs/tabid/205/Default.aspx" target="_blank">1.800.817.5187</a>' +
                '</li>' +
                '</ul>';
        }
    };

})();
