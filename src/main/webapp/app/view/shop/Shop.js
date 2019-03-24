function filterProducts (){
    var filteringPanel = Ext.getCmp('filter-panel');
    console.log("filtering Panel called " ,filteringPanel);
    if(filteringPanel){
        var root = filteringPanel.getRootNode();
        var filters = "";        
        root.childNodes.forEach(function(child){
            var name = child.data.text;
            filters +=name+"=";
            child.childNodes.forEach(function(filterValue){
                if(filterValue.data.checked){
                     filters+=filterValue.data.value+",";                    
                }
            });
            filters+=";";            
        });
        console.log("filtering root panel ",filters);
    }   else    {
        filters="";    
    }
    return filters;
};
var remoteStore= Ext.create('Ext.data.JsonStore', {
    fields: ['name', 'image','description','price','discountedPrice'],
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '/pagingfilter',
        //url: 'app/data/product.json',
        enablePaging: true,
        headers: { 
            'Content-Type' : 'text/plain' 
        },
        extraParams:{
        	filter:filterProducts()
        },
        reader: {
            type: 'json',
            rootProperty: 'products',
            totalProperty: 'totalCount'
        }
    },
    pageSize: 15,
    itemsPerPage:15,       
});
remoteStore.on('beforeload',function(){
	var proxy = remoteStore.getProxy();
	proxy.setExtraParam('filter',filterProducts());
});
Ext.define('estore.view.shop.Shop', {
    extend:'Ext.panel.Panel',    
    xtype: 'shop',    
    requires: [
        'Ext.toolbar.TextItem',
        'Ext.view.View',
        'Ext.ux.BoxReorderer',
        'Ext.ux.DataView.Animated'
    ],
    width:Ext.getBody().getViewSize().width-800,
    height:Ext.getBody().getViewSize().height-170,
               
    layout:{
        type:'vbox',
        align:'stretch',
        pack:'start'
    },    
    border:0,
    items: [{
        xtype: 'dataview',
        reference: 'dataview',
        store:remoteStore,
        plugins: {
            ptype: 'ux-animated-dataview',
        },
        autoScroll:true,
        itemSelector: 'div.dataview-multisort-item',
        overClass:'x-view-over',        
        tpl: Ext.create('Ext.XTemplate',
            '<tpl for=".">',
                '<div class="dataview-multisort-item">',
                    '<img src="resources/images/product_images/{image}" />',
                    '<h3>{name}</h3>',
                    '<center><b>US ${price}</b></center>',
                '</div>',
            '</tpl>'
        ),
    }],    
    dockedItems: [{
        xtype: 'pagingtoolbar',
        pageSize: 15,
        store: remoteStore,
        dock: 'bottom',
        displayInfo:true        
    }],
});