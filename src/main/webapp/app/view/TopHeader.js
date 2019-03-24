Ext.define('estore.view.TopHeader', {
        extend: 'Ext.container.Container',
        xtype: 'appHeader',
        title: 'E-Store Application',
        requires:['estore.view.Header'],
        layout:{
            type:'vbox',
            align:'stretch'
        },
        height:100,
        border:0,
        bodyCls:'header-menu-plain-background',
        items : [
            {
                xtype:'headerMenu',
                height:40                
            },{
                xtype:'component',                
                cls:'header-menu-plain-background',                
                autoEl:'div',
                border:0,
                html:'<div><img src="resources/images/tshirtshop.png"/></div>',
                align:'right',
                flex:1
            }
        ]
    }
);