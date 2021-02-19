### About
A Blocking implementation of the api service. Service doesn't respond or start processing the 
request till the previous request has been serviced.

#### Ingredients
Using only the bare minimum of imports or dependencies:
* weld - for DI management
* 

#### Run instructions
In blocking directory run

`./gradlew installDist &&  ./blocking/build/install/blocking/bin/blocking org.xyz.services.Application`