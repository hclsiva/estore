Ext.define('estore.view.main.Main',
{
	extend: 'Ext.container.Viewport',
    xtype:'app-main',
    id:'app-main',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Border',
		'estore.view.TopHeader',
		'estore.view.ContentPanel',
		'estore.view.navigation.Breadcrumb',
        'estore.view.Footer',
        'estore.view.shop.ProductFilter'
    ],         
    cls:'viewPortMargin',
    //margin:'0px 50px 0px 50px',    
    layout:{
        type:'vbox',
        align:'center',
        pack:'center'        
    },
    overflowY:'auto',       
    width:Ext.getBody().getViewSize().width-200,    
    initComponent: function() {        
        this.items= [{
            //region: 'north',
            xtype: 'appHeader',
        },{
            //region: 'center',
            xtype: 'contentPanel',
            reference: 'contentPanel',
            ariaRole: 'main',
                           
        },{
            //region: 'south',
            xtype:'appFooter',
        } ,]
        this.callParent(arguments);
        this.center();
    }
});
	