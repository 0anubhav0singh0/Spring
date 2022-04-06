package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;

// you don't have to add @Repository annotation on top of StudentRepository interface because this JpaRepository interface has a default implementation as SimpleJpaRepository and this class is already annotated with @Repository
// one more important point is JpaRepository interface bydefault provides Transaction for all its method hence we don't again have to add Transaction annotation in a service layer 
public interface StudentRepository extends JpaRepository<Student, Long> {

}
