Ext.define('estore.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',
	requires:['estore.view.shop.Shop'],
    onLoginClick: function() {
        var loginPanel = Ext.getCmp('login');
		loginPanel.destroy();
		Ext.create('estore.view.shop.Shop');
    }
});