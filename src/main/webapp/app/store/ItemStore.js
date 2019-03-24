Ext.define('estore.store.ItemStore', {
    extend: 'Ext.data.Store',
    fields: ['name', 'image','description','price','discountedPrice'],
    sortOnLoad:false,
    itemsPerPage:15,
    loading: true,
    proxy: {
        type: 'memory',
        enablePaging: true,
        url : 'app/data/product.json',
        reader: {
            type: 'json',
            timeout:30000,
            rootProperty: 'products',
            totalProperty: 'totalCount'
        }
    },
    autoLoad: true,
    pageSize: 15
});
