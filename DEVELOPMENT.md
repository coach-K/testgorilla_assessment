# testgorilla_assessment
Compile and run the jar file.
Please kindly checkout the different branches/tasks to see various implementation.
task-1
task-2
task-3
task-4 - TODO
task-5
task-6
task-7
task-8 - TODO
task-9

Save Words
POST http://localhost:8080/words
```
{
    "word1": "son",
    "word2": "daughter",
    "relation": "antonym"
}

```

All words
GET http://localhost:8080/words

Word by relation
GET http://localhost:8080/words?relation=antonym

Search Word
GET http://localhost:8080/words?source=son&target=antonym
