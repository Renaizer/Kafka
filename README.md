# How I installed kafka cluser server..
<p>lets see how I installed kafka cluser server with all required services running inside it on docker on my Local machine <p>

<h3>$ docker pull landoop/fast-data-dev</h3>

This will download managed docker container for kafka server. Now in order to run it 

<h3>$ docker run --rm --net=host lensesio/fast-data-dev</h3>

<p> This started all of the kafka services along with single kafka borker. I read it some where that single Kafka broker is 
capable of handling a stream containing hundreds of the messages in one second. I am about to validate this statement using Landoop
Managed cluser container.<p>

<p>All console based kafka activities were conducted succesfully. Eg Creating topic, sending message to it, consuming 
messages from topics</p>

<p> TBD : Write a producer object integrated in spark application running on one thread.<p>




