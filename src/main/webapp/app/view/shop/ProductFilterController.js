Ext.define('estore.view.shop.ProductFilterController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.productfiltercontroller',

    addValues:function(arrObj, value){
        arrObj.push(value);
    },
    createFilterObject:function(arrObj,name,values){
        arrObj.push(this.name,this.values);
    },
    filterProducts:function(me,isChecked){
        console.log("filterProducts called",me.get('text'),me.data.checked);
        var parent = me.parentNode;
        console.log("Parent = ",parent.get('text'),me.data.checked);        
        var filteringPanel = Ext.getCmp('filter-panel');
        filteringPanel.mask("Filtering. Please wait ...");        
        var task = new Ext.util.DelayedTask(function() {
            filteringPanel.unmask();        
        });
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
        console.log("filtering root panel ",JSON.stringify(filters));
        this.ajaxRequest(filters);
        task.delay(1000);
    },
    ajaxRequest:function(filters){
        console.log(JSON.stringify(filters));
        Ext.Ajax.request({                 
            url: '/filter',
            method:'GET',
            headers: { 
                'Content-Type' : 'text/plain' 
            },            
            useDefaultXhrHeader : false,
            params:{
            	filter:JSON.stringify(filters)
            },
            success:function(response){
                var respObj = Ext.JSON.decode(response.responseText);
                console.log(respObj);
            },
            failure:function(response){
                var respObj = response;
                console.log(response);                
            }
        });
    }

});