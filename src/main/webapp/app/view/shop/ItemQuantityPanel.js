Ext.define('estore.view.shop.ItemQuantityPanel', {
    extend: 'Ext.panel.Panel',
    xtype:'itemQuantityPanel',    
    border:0,
    items: [{        
        xtype:'fieldset',
        columnWidth: 0.5,
        title: 'Cart',
        collapsible: false,
        layout:{
            type:'vbox',
            align:'right',
            pack:'start'        
        },                
        items:[{
            xtype:'numberfield',        
            name: 'quantity',
            fieldLabel: 'Quantity',
            value: 0,
            maxValue: 10,
            minValue: 0,
            
        },{
            xtype:'button',
            name:'addToCart',
            text:'Add',
            iconCls:'empty-cart-ico',
            width:150
        }]
    }]
});