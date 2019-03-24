Ext.define('ApplicationImpl',
{
	extend:'Ext.app.Application',
	name:'estore',
	autoCreateViewport: false,
	enableQuickTips:true,	
	launch : function() {
		console.log("creating view port");
		//Ext.create('estore.view.main.Main');
		Ext.create('estore.view.login.Login');
		console.log("view port creation over");
	}
});