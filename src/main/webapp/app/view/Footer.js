Ext.define('estore.view.Footer', {
    extend: 'Ext.panel.Panel',
    xtype: 'appFooter',
    height: 30,
    border:0,
    //borderCls:'header-menu-plain-background',
    //bodyCls: 'x-panel-body-default-framed',
    width:Ext.getBody().getViewSize().width-200,
    layout: {
        type: 'hbox',
        align: 'center',
        pack: 'center'
    },         
	items : [{
		xtype: 'label',
        html: '2019 @ Turing',
        align:'center',        	
	}]

});
