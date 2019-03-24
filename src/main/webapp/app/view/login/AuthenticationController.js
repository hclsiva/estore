Ext.define('estore.view.login.AuthenticationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.authentication',

    //TODO: implement central Facebook OATH handling here

    onFaceBookLogin : function() {
        this.redirectTo('app-main', true);
    },

    onLoginButton: function() {
        Ext.getCmp('login').destroy();
        Ext.create('estore.view.main.Main');
        Ext.getCmp('app-main').show();       
    },

    onLoginAsButton: function() {
        this.redirectTo('app-main', true);
    },

    onNewAccount:  function() {
        this.redirectTo('app-main', true);
    },

    onSignupClick:  function() {
        this.redirectTo('app-main', true);
    },

    onResetClick:  function() {
        this.redirectTo('app-main', true);
    }
});