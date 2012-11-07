<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>RESTEasy Interceptor demo</title>
</head>
<body>

<h2>1. Post to a resource, return XML:</h2>
... but the interceptor doesn't triggered.
<form action="api/role" method="post">

<input type=text name="en" value="ein"/><br>
<input type=text name="to" value="schwei"/><br>
<input type=text name="tre" value="drei"/><br>

<input type="submit" value="Post it!" />
</form>
<h2>2. Get a resource that throws an exception, which is nicely formatted</h2>
The interceptor still doesn't trigger: 
<a href="api/name/testing">throw an exception</a>

<h2>3. Post to a resource that throws an exception</h2>
Somehow there isn't any MessageBodyWriter for application/x-www-form-urlencoded, so there's no nice formatting.
<form action="api/another" method="post">
<input type="hidden" name="yo" value="hey" />
<input type="submit" value="Fail" />
</form>

</body>
</html>
