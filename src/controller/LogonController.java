package controller;

public class LogonController {

	// ���O�I�����˗�����	�F�؃G���[�̓|�b�v�A�b�v�\��
	public static  void sendLogon(String userid, String password) {

		if(dao.EmployerDao.checkPassword(userid, password) == false){
			//�|�b�v�A�b�v�\��
			System.out.println("error password");
		}

		if(dao.EmployerDao.checkJinji(userid)){
			//�ǉ��A�폜�\�ɂ���
			System.out.println("you are jinji");
		}

	}

	// ���O�A�E�g���˗�����
	public void sendLogout() {


	}


	// �Ј��I�u�W�F�N�g�̔j�����˗�����
	public void sendEmployee() {

	}
}
