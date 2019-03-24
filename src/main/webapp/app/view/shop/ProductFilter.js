Ext.define('estore.view.shop.ProductFilter', {
    extend: 'Ext.tree.Panel',
    xtype: 'filter',
    id:'filter-panel',
    requires:['estore.view.shop.ProductFilterController' ],	
    layout:{
        type:'fit',
        align:'fit',
        pack:'start'
    },    
    header:false,
    rootVisible:false,
    useArrows:true,
    iconCls:'x-tree-icon',
    hideCollapseTool:true,
    collapsible:false,
    cls:'treeFontSmall',
    resizable: true,
    controller:'productfiltercontroller',
    listeners: 
	{
        checkchange: 'filterProducts',
    },
    border:0,
    store:{
        fields: [{
            name: 'text'
        }],
        autoLoad: true,
        sortOnLoad:false,
        proxy: {
            type: 'ajax',
            url:'app/data/filter.json',
            //url:'/cxf/logutility/downloader/logfiles',
            reader: {
                type: 'json',
                rootProperty: 'children'
            }
        }        
    }
});