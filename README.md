# Hello World Rest API

### Running the Application

- http://localhost:8080/hello-world

```txt
Hello World V1 abcde
```

- http://localhost:8080/hello-world-bean

```json
{"message":"Hello World"}
```

- http://localhost:8080/hello-world/path-variable/test

```json
{"message":"Hello World, test"}
```

# Base Microservice
hello-world-rest-api

### RUN HELM
version at least 3.5.4: https://github.com/helm/helm/releases
```bash
cd ./helm
```

##### USE HELM - INSTALL

Command syntax*:
```bash
helm upgrade hello-world-rest-api ./hello-world-rest-api --values=base/values/<TYPE>/<ENV>-values.yaml
```

Example for hello-world-rest-api dev:
```bash
helm upgrade hello-world-rest-api ./hello-world-rest-api --values=base/values/api/dev.yaml
```

*it is recommended, that you use `--dry-run` and `--debug` on the first run to see, what will be installed.

##### USE HELM - UPGRADE

Command syntax:
```bash
helm upgrade hello-world-rest-api ./hello-world-rest-api \
--values ./hello-world-rest-api/values/<TYPE>/all.yaml \
--values ./hello-world-rest-api/values/<TYPE>/<ENV>.yaml \
--set image.tag=<IMAGE> \
--atomic \
--install \
--history-max=3
```

Example for DEV:
```bash
helm upgrade hello-world-rest-api ./hello-world-rest-api \
--values ./hello-world-rest-api/values/api/all.yaml \
--values ./hello-world-rest-api/values/api/dev.yaml \
--set image.tag=0.0.1-SNAPSHOT \
--atomic \
--install \
--history-max=3  \
--dry-run
```

Example for PROD:
```bash
helm upgrade hello-world-rest-api ./hello-world-rest-api \
--values ./hello-world-rest-api/values/api/all.yaml \
--values ./hello-world-rest-api/values/api/prod.yaml \
--set image.tag=0.0.1 \
--atomic \
--install \
--history-max=3  \
--dry-run
```

#### LIST DEPLOYED SERVICES

```bash
helm ls
```

#### PURGE SERVICE

```bash
helm delete hello-world-rest-api
```
