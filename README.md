.\mvnw.cmd spring-boot:run

$ heroku login
$ git push heroku main (or push to remote main branch because heroku is linked to github for automatic deployments)
$ heroku open
$ heroku logs --tail


# Host API at Google Cloud (Google App Engine)
https://console.cloud.google.com/
https://docs.cloud.google.com/sdk/docs/install-sdk  


# Deploy using gcloud command
.\mvnw.cmd clean package  
gcloud auth login  
gcloud config set project mdj-opentrivia-api  
gcloud app deploy app.yaml --project=mdj-opentrivia-api


# URL
https://mdj-opentrivia-api.ew.r.appspot.com  