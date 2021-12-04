mvn spring-boot:run

$ heroku login
$ git push heroku main (or push to remote main branch because heroku is linked to github for automatic deployments)
$ heroku open
$ heroku logs --tail