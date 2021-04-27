# UserCenter
用户中心微服务，提供统一的用户管理、角色管理、权限管理、菜单管理、代码生成。
## 用户登录请求方法
用户登录功能需要进行用户认证与返回生成的JWT，是结合oauth项目实现。
具体请求方法如下：
+ post请求
+ 请求地址 http://gatewayIP:port/oauth/oauth/token gatewayIP:port为gateway运行的IP和端口，当前为39.96.7.6:8000
+ 请求参数，`client_id=password,client_secret=wangu123!@#,grant_type=password,username=用户名,password=密码`
用户名与密码填入实际值，前三个参数为固定值。
+ content-type为x-www-form-urlencodeed
返回值为json格式内容如下：
```$xslt
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "accessToken": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjEsImF1ZCI6WyJyaWQiXSwidXNlcl9uYW1lIjoiemhhbmdzYW4iLCJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNjA0ODMyOTk0LCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiL3N5c1VzZXIvKiJ9LHsiYXV0aG9yaXR5IjoiLyovKiJ9LHsiYXV0aG9yaXR5IjoiL3N5c1VzZXIvb25lIn0seyJhdXRob3JpdHkiOiIvc3lzUGVybWlzc2lvbi8qIn0seyJhdXRob3JpdHkiOiIvKioifSx7ImF1dGhvcml0eSI6Ii9zeXNSb2xlLyoifV0sImp0aSI6ImNkYmJhOTJjLWYzYjktNDdmYS05ZjgyLTY2M2IwZDRiY2U3YyIsImNsaWVudF9pZCI6InBhc3N3b3JkIn0.fOEMAkI6MUpiLC8Befb5cY9QJbXuakD-B24x5sCqbbOGaWXT3NfSSF3u5ZBKPm-GmX5e921d4vc2L7ycY1-WisvUr_lR8nYKhEiFjmyZ2ryI3nuydVah0rcywijWTkwXETHQqntHKSZJGuh-1MKAZsxAUn29a61GRIfic36U4-g",
        "refreshToken": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjEsImF1ZCI6WyJyaWQiXSwidXNlcl9uYW1lIjoiemhhbmdzYW4iLCJzY29wZSI6WyJhbGwiXSwiYXRpIjoiY2RiYmE5MmMtZjNiOS00N2ZhLTlmODItNjYzYjBkNGJjZTdjIiwiZXhwIjoxNjA1NjEwNTk0LCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiL3N5c1VzZXIvKiJ9LHsiYXV0aG9yaXR5IjoiLyovKiJ9LHsiYXV0aG9yaXR5IjoiL3N5c1VzZXIvb25lIn0seyJhdXRob3JpdHkiOiIvc3lzUGVybWlzc2lvbi8qIn0seyJhdXRob3JpdHkiOiIvKioifSx7ImF1dGhvcml0eSI6Ii9zeXNSb2xlLyoifV0sImp0aSI6ImZjZWY0NDgwLTMyNDMtNGZiNi1iZDYwLTA2NjJhNGU0ODg0OSIsImNsaWVudF9pZCI6InBhc3N3b3JkIn0.ffFynPoenBilu1HKd39wqHm3YXKyAWD1S2cIcEyo1CY3pm1e5DFEre8j-Zzz5wSvbWkjyXKMBtHkUuehxE1PgaMN25sWkvzXTkBZ-nqQNougfnI8wz8TQHNqjIScHd8OUZGivgSMsnZFwAkK3wgtMFYaISFibxtiiVUe43slSuQ",
        "expiration": 86399,
        "tokenType": "bearer"
    }
}
```
accessToken即为JWT，后续每个请求都携带`Authorization=Bearer jwt`的header。
**注意jwt替换为实际的accessToken，Bearer后有一个空格**
## 本地docker运行方法
本项目已配置nacos注册中心和配置中心，请自行修改ip和port。
+ 导入数据库，sql文件在resources/db目录下
+ 下载本项目后用idea打包为jar包，将生成的user-center-0.0.1-SNAPSHOT.jar移到docker目录下
```$xslt
cd docker #进入docker目录
docker build -t user-center .
docker run --name user-center -p 8200:8200 -d user-center
```
+ postman访问localhost:8200即可
## 远程服务器运行方法
本项目集成了github actions，fork本项目后，即可使用github提供的ci/cd，自动打包部署。
前置条件：
1. 远程服务器一台，开启22和8200端口，具有ssh登录用户名和密码，**服务器已安装docker**
2. 点击自己fork的仓库中的Setting，选择Secret，新增4个Secret,分别为DEPLOY_HOST、DEPLOY_USERNAME、DEPLOY_PASSWOR、DEPLOY_PORT，
对应的值分别为远程服务器ip地址、ssh登录用户名、ssh登录密码和ssh端口号即22。
3. 点击仓库中的Action，开启workflow功能，若页面无开启按钮代表已开启
访问nacos配置中心，新建user-center-product.yml文件，文件内容为：
```$xslt
discovery:
  ip: 远程服务器ip 
  weight: 1
```
现在只需往仓库push或者pr，Action会自动执行，可点击Action查看具体运行情况，成功后访问远程ip:8200即可。