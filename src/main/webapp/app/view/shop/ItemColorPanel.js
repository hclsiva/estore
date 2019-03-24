Ext.define('estore.view.shop.ItemColorPanel', {
    extend: 'Ext.form.Panel',
    requires:[
        'Ext.picker.Color'    
    ],
    xtype:'colors',
    id:'colors',
    border:0,
    items: [{        
        xtype:'fieldset',
        columnWidth: 0.5,       
        title: 'Available Colors',
        defaults: {anchor: '100%'},
        layout: 'anchor',
        collapsible: false,                
        layout: 'anchor',
        items:[{
            xtype:'colorpicker',
            colors:['000000','FFFFFF','35baf6','ff0000','ffa500','ffff00','008000','4b0082','800080']                        
        }] 
    }]
});