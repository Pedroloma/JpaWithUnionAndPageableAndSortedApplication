package com.example.jpawithunionandpageableandsorted.sample;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>
{

  @Query(value = "SELECT " +
      "tb " +
      "FROM Test tb " +
      "WHERE " +
      " (tb.type='A')" +
      " UNION " +
      "SELECT " +
      "tb " +
      "FROM Test tb " +
      "WHERE " +
      " (tb.type='B')" +
      " UNION " +
      "SELECT " +
      "tb " +
      "FROM Test tb " +
      "WHERE " +
      " (tb.type='C')",
      countQuery = "select count(tb.id) " +
          "FROM Test tb "
  )
  Page<Test> findAllWithUnions(Pageable pageable);

}
