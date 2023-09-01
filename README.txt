Pentru a usura procesul de testare si rulare a temei, am populat Repository-ul de masini CarsRepository cu 2 obiecte, precum cele din 
enuntul temei, in package-ul Bootstrap.

Pentru testarea temei este necesara apelarea endpointului 2, care face un Put si are efect final de creare a campului darkMode in Cookie,  
care in urmatoarele requesturi la localhost va fi prezent si va putea fi folosit. In postman se face un Put la localhost:8080/api/dark-mode
cu un Body obiect JSON cu "darkMode": true sau false. La apelarea primului endpoint de get-cars, aceasta valoare va putea fi accesata din Cookie.
