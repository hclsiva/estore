Ext.define('estore.view.login.Login', {
    extend: 'Ext.form.Panel',
    xtype: 'login',
	id:'login',
    requires: [
        'estore.view.login.LoginController',
        'Ext.form.Panel'
    ],

    controller: 'login',
    bodyPadding: 20,
    title: 'Login',
    closable: false,
    autoShow: true,
	defaultType: 'textfield',
    width: 350,
	items: [{
		xtype: 'textfield',
		name: 'username',
		fieldLabel: 'Username',
		allowBlank: false
	}, {
		xtype: 'textfield',
		name: 'password',
		inputType: 'password',
		fieldLabel: 'Password',
		allowBlank: false
	}, {
		xtype: 'displayfield',
		hideEmptyLabel: false,
		value: 'Enter any non-blank password'
	}],
	buttons: [{
		text: 'Login',
		formBind: true,
		listeners: {
			click: 'onLoginClick'
		}
	},{
		text: 'Cancel',
		formBind: true,
		listeners: {
			click: 'onCancelClick'
		}
	}]
    
});