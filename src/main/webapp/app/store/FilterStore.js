Ext.define('estore.store.FilterStore', {
    extend: 'Ext.data.TreeStore',
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
});