<body>
<h1 class="DatabaseTitle">数据库: strictfp</h1>
<h2>表格: article</h2>
<h3>索引:</h3>
<table border="0" cellspacing="0" summary="article" class="TableObject">
	<tr class="TableHeader StructureHeader"><th>名称</th><th>类型</th><th>属性</th><th>备注</th></tr>
	<tr class="Structure"><td  class="PrimaryKey">主索引</td><td>Id, pdate</td><td>unique</td><td></td></tr>
</table><br>
<h3>字段:</h3>
<table border="0" cellspacing="0" summary="article" class="TableObject">
	<tr class="TableHeader StructureHeader"><th>名称</th><th>类型</th><th>空</th><th>默认值</th><th>属性</th><th>备注</th></tr>
	<tr class="Structure"><td class="PrimaryKey">Id</td><td>int(11)</td><td>否</td><td>&lt;auto_increment&gt;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td class="PrimaryKey">pdate</td><td>date</td><td>否</td><td>2017-01-01</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>writerId</td><td>smallint(5) unsigned</td><td>否</td><td>0</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>tags</td><td>tinytext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>e.g. Tech,Music,Startalk</td>	</tr>
	<tr class="Structure"><td>category</td><td>tinytext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>title</td><td>tinytext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>brief</td><td>tinytext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>content</td><td>mediumtext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>up</td><td>mediumint(8) unsigned</td><td>否</td><td>0</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>down</td><td>mediumint(8) unsigned</td><td>否</td><td>0</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>click</td><td>mediumint(8) unsigned</td><td>否</td><td>0</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
</table><br>
<h2>表格: writer</h2>
<h3>索引:</h3>
<table border="0" cellspacing="0" summary="writer" class="TableObject">
	<tr class="TableHeader StructureHeader"><th>名称</th><th>类型</th><th>属性</th><th>备注</th></tr>
	<tr class="Structure"><td  class="PrimaryKey">主索引</td><td>Id</td><td>unique</td><td></td></tr>
</table><br>
<h3>字段:</h3>
<table border="0" cellspacing="0" summary="writer" class="TableObject">
	<tr class="TableHeader StructureHeader"><th>名称</th><th>类型</th><th>空</th><th>默认值</th><th>属性</th><th>备注</th></tr>
	<tr class="Structure"><td class="PrimaryKey">Id</td><td>int(11)</td><td>否</td><td>&lt;auto_increment&gt;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>name</td><td>tinytext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>motto</td><td>tinytext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>avatarURL</td><td>tinytext</td><td>否</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
	<tr class="Structure"><td>gender</td><td>tinyint(3)</td><td>否</td><td>0</td><td>&nbsp;</td><td>&nbsp;</td>	</tr>
</table><br>
</body>
</html>