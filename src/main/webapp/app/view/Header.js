Ext.define('estore.view.Header', {
    extend: 'Ext.panel.Panel',
    xtype: 'headerMenu',
    
    layout:{
      type:'hbox',
      align:'fit'
    },    
    requires:['Ext.form.Label',
              'Ext.form.FieldSet',
              'estore.view.SearchPanel'
    ],
    baseCls:'app-tool-bar',
    //bodyCls:'x-panel-body-default-framed',
    items : [{
      xtype:'tbfill'
    },
    {
      xtype:'searchPanel',                  
    },{
      xtype:'tbfill'
    },{
      xtype:'button',
      width: 'auto',
      maxHeight:50,
      iconCls: 'empty-cart-ico',
      enabled:true,
      text:'Cart',
      //cls:'header-menu-plain-background',
      menu: {
        showSeparator :false,
        plain:true,
        items: [{
          text: 'Items in cart',
        }]
      }
    },{
        xtype:'button',
        width: 'auto',
        maxHeight:50,
        iconCls: 'admin-ico',
      //  cls:'header-menu-plain-background',
        text:'Profile',
        menu: {
        showSeparator :false,
        plain:true,
        items: [{
          text: 'User Settings'
      },{
            text: 'Change Password'
        },{
            text: 'Logout',            
            }]
        }
  },{
    xtype:'button',
    width: 'auto',
    maxHeight:50,
    iconCls: 'help-ico',
    enabled:true,
    text:'Help',
    //cls:'header-menu-plain-background',
    menu: {
      showSeparator :false,
      plain:true,
      items: [{
        text: 'Info',
      },{
        text: 'Help'
      }]
    }
  }]
});
