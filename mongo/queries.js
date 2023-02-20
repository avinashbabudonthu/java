# create and use database
use database1

# check database in use
db

# show all databases
show dbs

# create collection named - emp
db.createCollection("collectionName")
db.createCollection("emp")
db.createCollection("company")

# show all collections
show collections

# insert queries
db.student.insert({"name": "Jack"})
db.student.insert({"name": "John"})
db.student.insert({"name": "Jim", "mail": "jim@gmail.com", 
    "department": {"name": "CSE", "lcoation":"India"}})
db.student.insert({"name": "Jane", "mail": "jane@gmail.com", 
    "subject": [{"name": "Java", "grade": 4.0}, {"name": "Mongo", "marks":4.0}]})

# count documents in student collection
db.student.count()

# find all documents
db.emp.find({})
db.student.find({})
db.student.find({}).pretty()

# find document by id
db.student.find({"_id": ObjectId("63f3513cc3d92d04b1f15533")})

# find document by name
db.student.find({"name": "Ana"})

# find first document
db.student.findOne()

# and query
db.student.find({$and: [{"name": "Jane"}, {"mail": "jane@gmail.com"}]})

# or query
db.student.find({$or: [{"name": "Jane"}, {"name": "Jack"}]})

# update one document
db.student.update({"name": "Jack"}, {$set: {"mail": "jack@gmail.com"}})

# update multiple documents
db.student.update({"name": "John"}, 
    {$set: {"name": "John1", "mail": "john@gmail.com"}},
    {multi: true}
    )

# remove all documents
db.student.remove({})

# remove document by name
db.student.remove({"name": "Jack"})