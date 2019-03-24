Ext.define('estore.view.shop.ItemSizePanel', {
    extend: 'Ext.panel.Panel',
    xtype:'itemSize',
    id:'itemSize',
    border:0,
    items: [{        
        xtype:'fieldset',
        columnWidth: 0.5,
        title: 'Size',
        collapsible: false,        
        defaults: {anchor: '100%'},
        layout: 'anchor',
        items:[{
            xtype:'radiogroup',            
            vertical:true,
            items:[
                {boxLabel:' S &nbsp;',name:'size',inputValue:'1'},
                {boxLabel:' M &nbsp;',name:'size',inputValue:'2',checked:true},
                {boxLabel:' L &nbsp;',name:'size',inputValue:'3'},
                {boxLabel:' XL &nbsp;',name:'size',inputValue:'4'},
                {boxLabel:' XXL &nbsp;',name:'size',inputValue:'5'}
            ]
        }] 
    }]
});