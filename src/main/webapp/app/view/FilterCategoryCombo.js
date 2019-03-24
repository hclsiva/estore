Ext.define('estore.view.FilterCategoryCombo',{
    extend:'Ext.form.ComboBox',
    xtype:'filterCategoryCombo',
    store:Ext.create('Ext.data.Store',{
        fields:['name'],
        autoLoad: true,
        proxy: {
            type: 'ajax',
            url: 'app/data/filterCategory.json',
            reader: {
                type:'json',
                rootProperty: 'filterCategory'                
            }
        },
    }),
    value:"Shirt",
    editable:false,    
    displayField:'name',
    valueField:'name',
    border:0,
});