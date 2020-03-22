# Toast-custom
A simple toast library to show custom toasts

[![](https://jitpack.io/v/PranavMalayil/Toast-custom.svg)](https://jitpack.io/#PranavMalayil/Toast-custom)
  
  
## How to ##
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. 
Add the dependency:
<pre><code>dependencies
 { 
    implementation 'com.github.PranavMalayil:Toast-custom:1.0'
 }</code></pre>
 
 # Example #
 
 ## Kotlin ##
 
 <pre><code>
 val mCtoast = Ctoast(this)
  mCtoast.title("check")
            .showToast()
 </code></pre>


### Methods ###

<table>
	<tr>
	<th>title</th>
	<th>Action</th>
    </tr>
	<tr>
		<td>title</td>
		<td>Set the toast messege text</td>
	</tr>
		<tr>
		<td>setBoldText</td>
		<td>Set the toast messege as bold text</td>
	</tr>
		<tr>
		<td>textColor</td>
		<td>Set the color of toast messege</td>
	</tr>
		<tr>
		<td>showToastImage</td>
		<td>Show toast messege with image</td>
	</tr>
	<tr>
		<td>setBackGroundColor</td>
		<td>Set the background color of toast messege</td>
	</tr>
	<tr>
		<td>setCustomStyle</td>
		<td>This will override all the propeties sets</td>
	</tr>
	
	<tr>
		<td>showToast</td>
		<td>Finally shows the toast messege</td>
	</tr>
</table>
