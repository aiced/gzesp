<#list goodsList as info>			
				<tr style=" height:100px;">
					<td class = "td_first" style="position:relative; height:100px;" >
							<a style="width:15px;height:15px;display: block;position:absolute;;left:10px;top:35px" onclick="showSelectedView(${info_index},${goodsList?size});return false;">
								<img id="unSelected" src=${resRoot}/image/goodsManager/unSelected.png style="width:15px;height:15px;display: block;position:absolute;">
							</a>
							
							<a  style="width:20px;height:20px;display: block;position:absolute;;left:12px;top:28px" onclick="showSelectedView(${info_index},${goodsList?size});return false;">
								<img id="leftItemSelected_${info_index}" src=${resRoot}/image/goodsManager/itemSelected.png style="width:20px;height:20px;display:block;visibility:hidden; position:absolute;" >							
							</a>
							
					</td>
					<td class = "td_second">
							<a id="itemSelected_${info_index}" style="background-color:white;display:block; width:100%;height:70px;margin-top:15px;margin-bottom:15px" onclick='itemClick(${info.goodsId})'>
         	     				<img src='${info.photoLinks}' style="display:block;width:75px;height:50px;float:left;margin-left:10px;margin-top:10px">
								<div style="float:left;width:170px;float:left;height:50px;margin-left:15px;margin-top:10px">								
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;color:#807E7E">总部商品－${info.goodsCtlgName}</p> 
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;color:#807E7E">${info.goodsName}</p> 
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;color:#807E7E">合约机:${info.addPrice} &nbsp<font color="#F70909">商品佣金:1000</font></p> 
								</div>
							</a>
					</td>
				</tr>
				</#list>