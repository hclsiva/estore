Ext.define('estore.view.shop.ShopGrid', {
    extend:'Ext.grid.Panel',
    xtype:'shopGrid',
    id:'shopGrid',
   //bodyCls:'header-menu-plain-background',
    requires:[
    'estore.view.shop.ShopGridController'
    ],    
    width:550,
    rowLines:false,
    controller:'shopGridAction',
    viewConfig: {
    	//markDirty:false,
        stripeRows: true,
		listeners : {
     		refresh : function (dataview) {
      			Ext.each(dataview.panel.columns, function (column) {
       						if (column.autoSizeColumn === true)
        						column.autoSize();
      				})
                 },
            select:'onRowClick',               		
    	}
      },
      initComponent:function(){
        var localStore =Ext.create('estore.store.ItemStore');
        var remoteStore= Ext.create('Ext.data.Store', {
            fields: ['name', 'image','description','price','discountedPrice'],
            autoLoad: true,
            proxy: {
                type: 'ajax',
                url: 'app/data/product.json',
                reader: {
                    rootProperty: 'products',
                    totalProperty: 'totalCount'
                }
            },
            pageSize: 100,
            listeners: {
                load: function () {
                    localStore.getProxy().setData(remoteStore.getRange());
                    localStore.load();
                }
            }
        });
        Ext.apply(this, {
             store:localStore,
             columns:[{
                header:'Product',
                dataIndex: 'image',
                flex: 2,
				sortable: false,
                maxWidth:250,
                renderer:function(value, metaData, record, rowIdx, colIdx, store, view){
                    var image = record.get('image');
                    var name = record.get('name');
                    console.log("image, name =",image, name);
                    var htmlSrc='<img src="resources/images/product_images/'+image+'\" /><p><center><div>'+name+'</div></<center></p>';
                    console.log("",htmlSrc);
                    return htmlSrc;
                }					
             },/*{
                header:'description',    
                dataIndex: 'description',
                maxWidth:300,
                cellWrap: true,
                flex:1,
				sortable: false,
				autoSizeColumn: false
            },*/
            {
                header:'Price',    
				dataIndex: 'price',
				flex: 1,
				sortable: false,
				autoSizeColumn: true
			},{
                header:'Discounted Price',    
				dataIndex: 'discountedPrice',
				flex: 1,
				sortable: false,
                autoSizeColumn: true,
                renderer:function(value){
                    if(value == 0){
                        return "No discount."
                    }
                        return value;
                }
            }],
            dockedItems: [{
                xtype: 'pagingtoolbar',
                store: localStore, // same store GridPanel is using
                dock: 'bottom',
                displayInfo: true,
                pageSize:10,
                bodyCls:'header-menu-plain-background',
            }],	
        }),
        
        this.callParent(arguments);
        this.onShoppingGridLoadCompleted(this,localStore);
    },
    onShoppingGridLoadCompleted:function(me,store){
        store.on('load',function( me, records, successful, operation, eOpts){            
            var record = records[0];
            console.log("onShoppingGridLoadCompleted called",me);
            var imagePanel = Ext.getCmp('itemImageFieldSet');
            var itemImage =Ext.getCmp('image-1');
            //itemImage.destroy();
            imagePanel.remove(itemImage);        
            imagePanel.insert(0,Ext.create('Ext.Img',{            
                id:'image-1',        
                border:1,        
                padding:10, 
                align: 'stretch',        
                width:300,
                height:300,
                src:'resources/images/product_images/'+record.get('image')   
            }));
            
            var productDescription = record.get('description');
            var descriptionComponent = Ext.getCmp('itemDetailsFieldSet');
            descriptionComponent.removeAll();
            descriptionComponent.add(Ext.create('Ext.panel.Panel',{
                id:'description',
                border:0,
                html:productDescription,
                height:300,
                width:200
            }));            
            console.log("Description changed");     
            
        });        
    }
});