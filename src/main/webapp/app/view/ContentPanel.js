Ext.define('estore.view.ContentPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'contentPanel',
    id: 'content-panel',   
	requires:[
        'estore.view.shop.ProductFilter',		
        'estore.view.shop.Shop',
        'estore.view.shop.ItemContentPanel'
    ], 
    header: {
        hidden: true
    },
    layout:{
        type:'hbox',
        align:'fit',
        pack:'start'
    },
    border:0,
    height:Ext.getBody().getViewSize().height-200,
    overflowY:'auto',         
	items:[
        {
            xtype:'filter',
            width:200,        
        } ,{            
            xtype: 'shop',                 
        }/*,{
            xtype:'itemContentPanel',
            
        }*/]
});
