// show all databases
show dbs

// create and use database
use database1

// check database in use
db

// create collection named - emp
db.createCollection("collectionName")
db.createCollection("emp")
db.createCollection("company")
db.createCollection("address")

// show all collections
show collections

// insert queries
db.student.insert({"name": "Jack"})
db.student.insert({"name": "John"})
db.student.insert({"name": "Jim", "mail": "jim@gmail.com", 
    "department": {"name": "CSE", "lcoation":"India"}})
db.student.insert({"name": "Jane", "mail": "jane@gmail.com", 
    "subject": [{"name": "Java", "grade": 4.0}, {"name": "Mongo", "marks":4.0}]})
db.student.insert({"name": "Ana", "mail": "ana2@gmail.com"})

db.student.insertMany([

    {"name": "Jack", "mail": "jack@gmail.com", "subjects": [{"name": "Java", "grade": 4.0}], "department": {"name": "Dept1", "location": "Hyerabad"}},

    {"name": "John", "mail": "john@gmail.com", "subjects": [{"name": "MongoDB", "grade": 3.9}], "department": {"name": "Dept2", "location": "Hyerabad"}},

    {"name": "Jim", "mail": "jim@gmail.com", "subjects": [{"name": "Spring", "grade": 3.8}], "department": {"name": "Dept3", "location": "Hyerabad"}},

    {"name": "Jane", "mail": "jane@gmail.com", "subjects": [{"name": "Maven", "grade": 3.7}], "department": {"name": "Dept4", "location": "Hyerabad"}},

    {"name": "Ana", "mail": "ana@gmail.com", "subjects": [{"name": "Gradle", "grade": 3.6}], "department": {"name": "Dept5", "location": "Hyerabad"}},

    {"name": "Ami", "mail": "ami@gmail.com", "subjects": [{"name": "Spring Data Mongo", "grade": 3.5}], "department": {"name": "Dept6", "location": "Hyerabad"}},

    {"name": "Jenny", "mail": "jenny@gmail.com", "subjects": [{"name": "AWS", "grade": 3.4}], "department": {"name": "Dept7", "location": "Hyerabad"}},

    {"name": "Dan", "mail": "dan@gmail.com", "subjects": [{"name": "REST API", "grade": 3.3}], "department": {"name": "Dept8", "location": "Hyerabad"}},

    {"name": "Jenifer", "mail": "jenifer@gmail.com", "subjects": [{"name": "GraphQL", "grade": 3.2}], "department": {"name": "Dept9", "location": "Hyerabad"}},

    {"name": "Julia", "mail": "julia@gmail.com", "subjects": [{"name": "GraphDB", "grade": 3.1}], "department": {"name": "Dept10", "location": "Hyerabad"}},

    {"name": "Ami", "mail": "ami2@gmail.com", "subjects": [{"name": "Spring Data Mongo", "grade": 3.5}], "department": {"name": "Dept11", "location": "Hyerabad"}},

    {"name": "Anni", "mail": "anni2@yahoo.com", "subjects": [{"name": "Spring Data Mongo", "grade": 3.5}], "department": {"name": "Dept11", "location": "Hyerabad"}},

    {"name": "Jason", "mail": "jason@yahoo.com", "subjects": [{"name": "Spring Data Mongo", "grade": 3.5}], "department": {"name": "Dept11", "location": "Hyerabad"}},

    {"name": "Jimmy", "mail": "jimmy@yahoo.com", "subjects": [{"name": "Spring Data Mongo", "grade": 3.5}], "department": {"name": "Dept11", "location": "Hyerabad"}},
    
    {"name": "Jimmy2", "mail": "jimmy2@yahoo.com", "subjects": [{"name": "Spring Data Mongo", "grade": 3.5}], "department": {"name": "Dept11", "location": "Hyerabad"}},
    
    {"name": "Jimmy3", "mail": "jimmy3@yahoo.com", "subjects": [{"name": "Spring Data Mongo", "grade": 3.5}], "department": {"name": "Dept11", "location": "Hyerabad"}}

])

// update multiple documents
db.student.update({"name": "John"}, 
    {$set: {"name": "John1", "mail": "john@gmail.com"}},
    {multi: true}
    )

// remove all documents
db.student.remove({})

// remove document by name
db.student.remove({"name": "Jack"})

// count documents in student collection
db.student.count()

// find all documents
db.emp.find({})
db.student.find({})
db.student.find({}).pretty()

// find document by id
db.student.find({"_id": ObjectId("63f3513cc3d92d04b1f15533")})

// find document by name
db.student.find({"name": "Ami"})

// find first document
db.student.findOne()

// and query
db.student.find({$and: [{"name": "Jane"}, {"mail": "jane@gmail.com"}]})

// or query
db.student.find({$or: [{"name": "Jane"}, {"name": "Jack"}]})

// update one document
db.student.update({"name": "Jack"}, {$set: {"mail": "jack@gmail.com"}})



// limit number of records

db.student.find({}).limit(3)



// skip number of records

db.student.find({}).skip(2)



// using skip and limit for pagination

db.student.find({}).skip(2).limit(1)



// sort by name in ascending order

db.student.aggregate(

[

    {$sort: {name: 1}}

]

)

    

// sort by name in descending order

db.student.aggregate(

[

    {$sort: {name: -1}}

]

)

    

// sort by name and mail in ascending order

db.student.aggregate(

[

    {$sort: {name: 1, mail: 1}}

]

)

    

// like query - no need of double quotes
db.student.find({"mail": /gmail/})
db.student.find({"mail": /yahoo/})

// name starts with Jimmy
db.student.find({"name": /^Jimmy/})