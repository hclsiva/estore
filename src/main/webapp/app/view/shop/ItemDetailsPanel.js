Ext.define('estore.view.shop.ItemDetailsPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'itemInfo',
    id: 'itemInfo',
    requires:[
        'estore.view.shop.ItemSizePanel', 
        'estore.view.shop.ItemColorPanel'       
    ],
    layout:{
        type:'vbox',
        align:'fit',
        pack:'start'        
    },
    border:0,
    paddingBorder:0,
    items:[{        
        xtype:'fieldset',
        columnWidth: 0.5,
        title: 'Description',
        collapsible: false,        
        defaults: {anchor: '100%'},
        layout: 'anchor',
        height:200,
        id:'itemDetailsFieldSet',
        items:[{
            xtype:'panel',
            id:'description',
            border:0,
            html:'<b>This is t shirt</b>',
        }]
    },{
        xtype:'itemSize'
    },{
        xtype:'colors'
    }]
});