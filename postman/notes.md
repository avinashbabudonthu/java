# Get response into Test script
```
var response = pm.response.json()
```
# Print response to console
```
console.log( JSON.stringify(pm.response.json()))
```
# Print response json into Body Visualize tab
```
template = `<pre><code>{{response}}</code></pre>`;
console.log( JSON.stringify(pm.response.json().data, undefined, 2))
// Set visualizer
pm.visualizer.set(template, {
    // Pass the response body parsed as JSON as `data`
    response: JSON.stringify(pm.response.json().data, undefined, 2)
});
```