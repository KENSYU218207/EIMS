package controller;

//���O�I���̍ۂɕK�v�Ȑ���N���X
public class LogonController {

	// ���\�b�h�F���O�I�����˗�����
	public static void sendLogon(String userid, String password) {
		// ���O�I����ʂœ��͂��ꂽ[�Ј��ԍ��E�p�X���[�h]���Ј�DAO�Ɉ����n��

		// �Ј��I�u�W�F�N�g�̃C���X�^���X�𐶐�

		// �F�؃G���[�̏ꍇ�A�|�b�v�A�b�v�\��
		if (dao.EmployerDao.checkPassword(userid, password) == false) {
			System.out.println("error password");
		}

		// �Ј����l���ł���ꍇ�A�ǉ��폜�ύX���\�ɂ���
		if (dao.EmployerDao.checkJinji(userid)) {
			System.out.println("you are jinji");
		}

	}

	// ���\�b�h�F���O�A�E�g���˗�����
	public void sendLogout() {
		// ���O�I�����Ă����Ԃ̃��[�U���A���O�A�E�g�����ꍇ�ɌĂяo�����

		// �Ј��I�u�W�F�N�g�̔j��

		// ��������iSearchController�j�ɁA�������ʂ̎Ј����X�g�̔j�����˗�����

	}
}
