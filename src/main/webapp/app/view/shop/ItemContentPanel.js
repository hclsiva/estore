Ext.define('estore.view.shop.ItemContentPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'itemContentPanel',
    id: 'itemContentPanel',
    requires:[
        'estore.view.shop.ItemPanel'
    ],    
    layout:{
        type:'vbox',
        align:'stretch',
        pack:'start'        
    },
    items:[{
        xtype:'itemPanel',
        border:0,
        flex:1
    }]
});