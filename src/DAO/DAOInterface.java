package DAO;

public interface DAOInterface<T> {
	public int Them(T t);
	public int Sua(T t);
	public int Xoa(T t);
	public boolean check(T t);
}
