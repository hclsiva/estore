Ext.define('estore.view.shop.ShopGridController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.shopGridAction',

    onRowClick:function(me, record, index, eOpts){        
        var imagePanel = Ext.getCmp('itemImageFieldSet');
        var itemImage =Ext.getCmp('image-1');
        itemImage.destroy();
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
    },

    onShoppingGridLoad:function(me){        
        console.log("onShoppingGridLoad called ----");
    }
});