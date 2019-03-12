package com.bridgelabz.fundoonotes.Utility;

public interface TokenGenerator {
	String generateToken(String id);

	int authenticateToken(String token);
}
