Ext.define('estore.view.SearchPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'searchPanel',
	requires:[
        'estore.view.FilterCategoryCombo',		
		'estore.view.shop.ShopGrid'
    ],     
    layout:{
        type:'hbox',        
    },
    border:0,
    baseCls:'app-tool-bar',
	items:[
        {
            xtype:'filterCategoryCombo',            
            width:135,
            align:'center',
        },{
            xtype:'panel',
            width:10,
            border:0
        },
        {
            xtype: 'textfield',
            border:0,
            width:600,                        
            name: 'query',
            emptyText:'Name',      
            triggers:{
                search:{
                cls:'x-form-search-trigger',
                handler: function () {
                }
              }
            }
        }
        ]
    }
);
