package com.data.couch.base.repository;

import com.data.couch.base.entity.Building;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "building", viewName = "all")
public interface BuildingRepository extends CouchbasePagingAndSortingRepository<Building, String> {
}
