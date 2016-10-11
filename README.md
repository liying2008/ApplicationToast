ApplicationToast
====
----
使用Application作为Context的Toast，具有即时显示的特性。 
引入(Download)
----
## Use Gradle  
```gradle  
repositories {
  mavenCentral() // jcenter() works as well because it pulls from Maven Central
}

dependencies {
  compile 'cc.duduhuo.applicationtoast:applicationtoast:0.2'
}
```

## Or Maven  
```xml  
<dependency>
  <groupId>cc.duduhuo.applicationtoast</groupId>
  <artifactId>applicationtoast</artifactId>
  <version>0.2</version>
  <type>pom</type>
</dependency>
```

## Or Ivy  
```xml  
<dependency org='cc.duduhuo.applicationtoast' name='applicationtoast' rev='0.2'>
  <artifact name='$AID' ext='pom'></artifact>
</dependency>
```
使用(Usage)
----
## 第一步(The First Step)
在应用的Application类的<code>onCreate</code>方法中初始化<code>AppToast</code>类。如下：

```java  
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppToast.init(this);
    }
}
```

**注意：不要忘记在<code>AndroidManifest.xml</code>文件中的<code>application</code>节点下配置<code>android:name</code>属性。**    
## 第二步(The Second Step)
尽情使用。  
```java  
AppToast.showToast("Toast 1");
```

```java  
AppToast.showToast(R.string.toast2);
```

```java  
AppToast.showToast("Toast 3", Toast.LENGTH_LONG);
```

```java  
AppToast.showToast(R.string.toast4, Toast.LENGTH_SHORT);
```

```java  
Toast toast = AppToast.getToast();
toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
toast.setText("自定义Toast");
toast.setDuration(Toast.LENGTH_SHORT);
toast.show();
```
方法说明(Methods)
----
| 方法名 | 返回值类型 | 备注
| --- | --- |  ---
| init(Application) | void | AppToast initialization
| showToast(@StringRes int) | void |  Display Toast
| showToast(CharSequence) | void |  Display Toast
| showToast(@StringRes int, @Duration int) | void | Display Toast
| showToast(CharSequence, @Duration int) | void | Display Toast
| getToast() | Toast |  Get a Toast object
| getApplication() | Application | Get this Application

效果演示(Demo)
----
![Demo](/demo/demo.gif)

作者(Author)
----
李颖 ([@独毒火][2])  
[liruoer2008@yeah.net][3]

日期(Date)
----
2016-10-11  

License
----

	Copyright 2016 LiYing
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.


  [2]: http://weibo.com/neuliying
  [3]: mailto:liruoer2008@yeah.net