<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>RESTEasy Interceptor demo</title>
</head>
<body>

<h2>1a. Post to a resource, return XML:</h2>
... but the interceptors doesn't trigger.
<form action="api/role" method="post">

<input type=text name="en" value="ein"/><br>
<input type=text name="to" value="schwei"/><br>
<input type=text name="tre" value="drei"/><br>

<input type="submit" value="Post it!" />
</form>
<h2>1b. Post to a resource, return XML:</h2>
... which actually triggers the MessageBodyReaderInterceptor, the only difference is in the method signature:
<b>postTest(String formParams)</b> seems to work, while <b>post(MultivaluedMap&lt;String, String&gt; formParams)</b> doesn't.
<br>The PreProcessInterceptor is not triggered, though...<br>
<form action="api/roletest" method="post">

    <input type=text name="en" value="ein"/><br>
    <input type=text name="to" value="schwei"/><br>
    <input type=text name="tre" value="drei"/><br>

    <input type="submit" value="Post it!" />
</form>

<h2>2. Get a resource that throws an exception, which is nicely formatted</h2>
The interceptors still doesn't trigger:
<a href="api/name/testing">throw an exception</a>

<h2>3. Post to a resource that throws an exception</h2>
Somehow there isn't any MessageBodyWriter for application/x-www-form-urlencoded, so there's no nice formatting.
<form action="api/another" method="post">
<input type="hidden" name="yo" value="hey" />
<input type="submit" value="Fail" />
</form>

</body>
</html>
