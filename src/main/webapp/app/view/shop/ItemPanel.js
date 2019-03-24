Ext.define('estore.view.shop.ItemPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'itemPanel',
    id: 'itemPanel',
    requires:[
        'estore.view.shop.ItemImagePanel',
        'estore.view.shop.ItemDetailsPanel'
    ],
    layout:{
        type:'hbox',
        align:'stretch',
        pack:'start'        
    },
    border:0,
    items:[{
        xtype:'itemImage',                               
    },{
        xtype:'itemInfo',
        padding:20,
        border:1
    }]
});