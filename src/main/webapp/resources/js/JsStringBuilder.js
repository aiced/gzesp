function StringBuilder(){  
    this.init();  
};  
//初始化StringBuilder类  
StringBuilder.prototype.init = function(){  
    this.array = [];  
};  
//追加数据到StringBuilder类  
StringBuilder.prototype.append = function(element){  
    this.array.push(element);  
};  
//转换成String  
StringBuilder.prototype.toString = function(){  
    return this.array.join("");  
};