Ext.define('estore.view.shop.ItemImagePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'itemImage',
    id:'itemimage',    
    border:1,
    requires:[
        'estore.view.shop.ItemQuantityPanel'    
    ],
    layout:{
        type:'vbox',
        align:'stretch',
        pack:'start'        
    },
    padding:10,    
    items:[{
        xtype:'fieldset',
        columnWidth: 0.5,
        title: 'Product Image',
        collapsible: false,                
        padding:10, 
        align: 'fit',                
        width:300,
        id:'itemImageFieldSet',
        items:[{
            xtype:'image',
            id:'image-1',        
            border:1,        
            src:'resources/images/product_images/arc-d-triomphe.gif'                
        }]
    },{
        xtype:'itemQuantityPanel',                
        border:1,
                                        
    }]
});