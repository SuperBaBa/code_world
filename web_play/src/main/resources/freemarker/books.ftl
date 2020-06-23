<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>
</head>
<body>
welcome ${name}  to freemarker!
<table border="1">
    <tr>
        <td>books no</td>
        <td>books name</td>
        <td>books author</td>
    </tr>
    <#if resource ??&&(resource?size>0)>
        <#list resource as book>
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
            </tr>
        </#list>
    </#if>
</table>
</body>
</html>