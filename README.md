# News

There is now <a href="https://martinfowler.com/articles/demo-front-end.html">an article detailing the Demo Front-End pattern</a>!

Rewrote the JavaScript code to vanilla; we no longer use jQuery

# About

This is a "hello, world" demo for the [Demo Frontends for API-Only Products](https://www.thoughtworks.com/radar/techniques/demo-frontends-for-api-only-products) technique that appears on the March 2023 edition of the Thoughtworks Technology Radar.

The intent is to show how easy it is to set up a demo page that works better than tools like Postman for test-driving an API.

This particular project uses vanilla JavaScript, because it's very simple. Of course you could use React or other libraries; the important thing is to avoid setting up a separate JavaScript build for this, because we want the demo page to be instantly available after a change to either the Spring Boot app, or the HTML/JavaScript code.

# How to

Run the application with `./gradlew bootRun`, then visit http://localhost:8080/testdrive/index.html
